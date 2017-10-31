package com.greenlabs.crudsample;

import org.junit.Test;

/**
 * Created by kristiawan on 10/7/17.
 */
public class DbConnectionTest {
    @Test
    public void getConnection() throws Exception {
        System.out.println(DbConnection.getInstance().getConnection());
    }
}