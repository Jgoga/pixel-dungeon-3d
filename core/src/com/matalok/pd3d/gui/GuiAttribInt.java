/*
 * Pixel Dungeon 3D
 * Copyright (C) 2016-2018 Alex Fomins
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

//------------------------------------------------------------------------------
package com.matalok.pd3d.gui;

//------------------------------------------------------------------------------
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.matalok.pd3d.renderer.RendererAttrib;
import com.matalok.pd3d.shared.UtilsClass;

//------------------------------------------------------------------------------
public class GuiAttribInt 
  extends GuiAttrib {
    //**************************************************************************
    // STATIC
    //**************************************************************************
    private static final UtilsClass.IdNameMap cull_face = new UtilsClass.IdNameMap(); 
    static {
        cull_face.put((long)GL20.GL_NONE,  "none");
        cull_face.put((long)GL20.GL_FRONT, "front");
        cull_face.put((long)GL20.GL_BACK,  "back");
        cull_face.Init();
    }

    //**************************************************************************
    // GuiAttribInt
    //**************************************************************************
    public GuiAttribInt(RendererAttrib.AInt.Cfg cfg, 
      GuiAttrib.Listener listener) {
        super(RendererAttrib.Type.INT, cfg, listener);
    }

    //**************************************************************************
    // GuiAttrib
    //**************************************************************************
    @Override public void OnCreateBody() {
        final RendererAttrib.AInt.Cfg cfg = (RendererAttrib.AInt.Cfg)m_cfg;

        final GuiSelectBox sbox = add(new GuiSelectBox(cull_face).SetId(cfg.value, false))
          .expandX().fillX().getActor();
        sbox.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent event, Actor actor) {
                cfg.value = (int)sbox.GetId();
                OnUpdate();
            }
        });
    }
}
