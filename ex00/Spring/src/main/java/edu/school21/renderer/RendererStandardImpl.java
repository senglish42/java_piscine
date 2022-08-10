package edu.school21.renderer;

import edu.school21.preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    private final PreProcessor pp;
    RendererStandardImpl(PreProcessor pp)
    {
        this.pp = pp;
    }
    @Override
    public void getMsg(String str)
    {
        System.out.println(pp.getStr(str));
    }
}
