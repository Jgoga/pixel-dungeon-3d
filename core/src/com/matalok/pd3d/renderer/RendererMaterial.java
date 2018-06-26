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
package com.matalok.pd3d.renderer;

//------------------------------------------------------------------------------
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;

//------------------------------------------------------------------------------
public class RendererMaterial 
  extends Material 
  implements RendererAttribStack.IOwner {
    //**************************************************************************
    // RendererMaterial
    //**************************************************************************
    private RendererAttribStack m_attrib_container;

    //--------------------------------------------------------------------------
    public RendererMaterial(RendererAttribStack.Cfg cfg) {
        m_attrib_container = new RendererAttribStack(this, cfg);
    }

    //**************************************************************************
    // RendererAttribContainer.IOwner
    //**************************************************************************
    @Override public void SetAttrib(Object attrib) {
        if(attrib instanceof Attribute) {
            set((Attribute)attrib);
        }
    }

    //--------------------------------------------------------------------------
    @Override public RendererAttribStack GetAttribStack() {
        return m_attrib_container;
    }

    //--------------------------------------------------------------------------
    @Override public void ClearAttrib(long attrib_mask) {
        remove(mask);
    }
}
