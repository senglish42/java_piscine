package edu.school21.preprocessor;

public class PreProcessorToLowerImpl implements PreProcessor {
    PreProcessorToLowerImpl() {}
    @Override
    public String getStr(String str)
    {
        return str.toLowerCase();
    }
}
