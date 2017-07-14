package component.zk.curator.listener;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.zookeeper.CreateMode;

/**
 * Created by wangjianjun on 2017/7/12.
 */
public class CuratorWatcher {

    public static void addWatcherNode(CuratorFramework client,String path,boolean isCompress){

        NodeCache nodeCache = new NodeCache(client,path,isCompress);
        try {
            nodeCache.start(true);
            nodeCache.getListenable().addListener(new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    System.out.println("路径"+nodeCache.getCurrentData().getPath());
                    System.out.println("数据"+new String(nodeCache.getCurrentData().getData()));
                    System.out.println("状态"+nodeCache.getCurrentData().getStat());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addWatcherChildrenNode(CuratorFramework client,String path,boolean isCompress){

        PathChildrenCache childrenCache = new PathChildrenCache(client,path,isCompress);
        try {
            childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
            childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                    switch (event.getType()){
                        case CHILD_ADDED:
                            System.out.println("CHILD_ADDED，类型：" + event.getType() + "，路径：" + event.getData().getPath() + "，数据：" +
                                    new String(event.getData().getData()) + "，状态：" + event.getData().getStat());
                            break;
                        case CHILD_UPDATED:
                            System.out.println("CHILD_UPDATED，类型：" + event.getType() + "，路径：" + event.getData().getPath() + "，数据：" +
                                    new String(event.getData().getData()) + "，状态：" + event.getData().getStat());
                            break;
                        case CHILD_REMOVED:
                            System.out.println("CHILD_REMOVED，类型：" + event.getType() + "，路径：" + event.getData().getPath() + "，数据：" +
                                    new String(event.getData().getData()) + "，状态：" + event.getData().getStat());
                            break;
                        default:
                            break;
                    }

                }
            });

//            //测试
//            client.create().forPath("/super", "123".getBytes());
//            client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/super/c1", "c1内容".getBytes());
//            //经测试，不会监听到本节点的数据变更，只会监听到指定节点下子节点数据的变更
//            client.setData().forPath("/super", "456".getBytes());
//            client.setData().forPath("/super/c1", "c1新内容".getBytes());
//            client.delete().guaranteed().deletingChildrenIfNeeded().forPath("/super");
//             Thread.sleep(5000);
//            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addTreeCacheNode(CuratorFramework client,String path,boolean isCompress){

        TreeCache treeCache = new TreeCache(client,"/treeCache");
        try {
            treeCache.start();
            treeCache.getListenable().addListener(new TreeCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                    switch (treeCacheEvent.getType()) {
                        case NODE_ADDED:
                            System.out.println("NODE_ADDED：路径：" + treeCacheEvent.getData().getPath() + "，数据：" + new String(treeCacheEvent.getData().getData())
                                + "，状态：" + treeCacheEvent.getData().getStat());
                            break;
                        case NODE_UPDATED:
                            System.out.println("NODE_UPDATED：路径：" + treeCacheEvent.getData().getPath() + "，数据：" + new String(treeCacheEvent.getData().getData())
                                + "，状态：" + treeCacheEvent.getData().getStat());
                            break;
                        case NODE_REMOVED:
                                System.out.println("NODE_REMOVED：路径：" + treeCacheEvent.getData().getPath() + "，数据：" + new String(treeCacheEvent.getData().getData())
                                    + "，状态：" + treeCacheEvent.getData().getStat());
                            break;
                        default:
                            break;
                        }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
