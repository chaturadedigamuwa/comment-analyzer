package com.ikhokha.commentanalize.factory;
import com.ikhokha.commentanalize.contact.CommentAbstractFactory;
import com.ikhokha.commentanalize.util.Action;
import java.util.HashMap;
import java.util.Map;

/**
 * class to map the different kind od operations like length ops and word comparison ops. In future can add more operators.
 */
public class CommentFactoryProvider {

    static Map<String, CommentAbstractFactory> operationsMapper = new HashMap<>();

    static {
        operationsMapper.put(Action.LENGTH.name(), new LengthFactory());
        operationsMapper.put(Action.WORD.name(), new WordsFactory());
        // more operators
    }
    public static CommentAbstractFactory getFactory(String choice){

        return operationsMapper.get(choice);
    }

}
