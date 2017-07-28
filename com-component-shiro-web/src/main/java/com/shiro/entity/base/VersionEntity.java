/**
 *
 */
package com.shiro.entity.base;

/**
 * @author houjun
 */
public abstract class VersionEntity extends StandardEntity implements HasVersion {

    private long edition = HasVersion.START_EDITION;

    /**
     * 版本号,用于乐观锁控制
     */
    public long getEdition() {
        return edition;
    }

    /**
     * 版本号，用于乐观锁控制，请不要主动调用改方法进行设置
     */
    public void setEdition(long edition) {
        this.edition = edition;
    }

}
