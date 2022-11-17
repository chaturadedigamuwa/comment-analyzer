package com.ikhokha.commentanalize.contact;

import java.util.List;

/**
 * abstract factory class to implement from factory classes
 * @param <T>
 */
public interface CommentAbstractFactory<T> {

    /**
     * useful method in factory classes to return the same contract
     * @param line
     * @return
     */
    T create(CharSequence line);

}
