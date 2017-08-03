/**
 *
 */
package com.base.util.entity;

/**
 * 版本控制接口（用于乐观锁控制）
 *
 * @author houjun
 */
public interface HasVersion {

    int START_EDITION = 1;

    long getEdition();

    void setEdition(long edition);
}
