//------------------------------------------------------------------------------
package com.matalok.scenegraph;

//------------------------------------------------------------------------------
public class SgUtils {
    //**************************************************************************
    // IPlatform
    //**************************************************************************
    public static interface IPlatform {
        //----------------------------------------------------------------------
        public void Dbg(String fmt, Object... args);
        public void Inf(String fmt, Object... args);
        public void Err(String fmt, Object... args);
        public void Assert(boolean statement, String fmt, Object... args);
    };

    //**************************************************************************
    // IManaged
    //**************************************************************************
    public interface IManaged {
        //----------------------------------------------------------------------
        public void OnCleanup();
    }

    //**************************************************************************
    // INode
    //**************************************************************************
    public interface INode {
        //----------------------------------------------------------------------
        public int SgGetId();
        public String SgGetName();
        public String SgGetNameId();
    }

    //**************************************************************************
    // IWriter
    //**************************************************************************
    public interface IWriter {
        //----------------------------------------------------------------------
        public void Write(String str, Object... args);
        public void Flush();
    }
}
