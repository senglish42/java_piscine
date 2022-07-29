package edu.school21.renderer;

import edu.school21.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {
    private final PreProcessor pp;
    RendererErrImpl(PreProcessor pp)
    {
        this.pp = pp;
    }
    @Override
    public void getMsg(String str)
    {
        System.err.println(pp.getStr(str));
    }
}
