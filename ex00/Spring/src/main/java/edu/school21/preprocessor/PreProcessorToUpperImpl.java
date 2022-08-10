package edu.school21.preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String getStr(String str)
    {
        return str.toUpperCase();
    }
}
