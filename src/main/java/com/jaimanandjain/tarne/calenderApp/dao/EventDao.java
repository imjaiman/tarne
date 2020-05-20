/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jaimanandjain.tarne.calenderApp.dao;

/**
 * @author rahul.jaiman
 * @version $Id: MeetingDao.java, v 0.1 2020-05-13 00:53 rahul.jaiman Exp $$
 */
public interface MeetingDao {
    boolean isMeetingConflicting(long startTime, long endTime, String roomNo);
}