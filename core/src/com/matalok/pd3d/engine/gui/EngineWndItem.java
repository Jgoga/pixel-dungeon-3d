//------------------------------------------------------------------------------
package com.matalok.pd3d.engine.gui;

//------------------------------------------------------------------------------
import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.utils.Align;
import com.matalok.pd3d.desc.DescItem;
import com.matalok.pd3d.gui.GuiProgressBar;
import com.matalok.pd3d.map.MapEnum;

//------------------------------------------------------------------------------
public class EngineWndItem 
  extends EngineWndInfo {
    //**************************************************************************
    // EngineWndItem
    //**************************************************************************
    private DescItem m_item;
    private Cell<GuiProgressBar> m_durability;
    private Map<String, ClickListener> m_buttons;

    //--------------------------------------------------------------------------
    public EngineWndItem() {
        super(false);
    }

    //--------------------------------------------------------------------------
    public EngineWndItem Init(DescItem item, Map<String, ClickListener> buttons) {
        m_item = item;
        m_buttons = buttons;
        return this;
    }

    //**************************************************************************
    // EngineWnd
    //**************************************************************************
    @Override public EngineWnd OnPostReset() {
        super.OnPostReset();

        Set(m_item.name, MapEnum.ItemType.Get(m_item.sprite_id), m_item.info, m_buttons, 3);
        if(m_item.durability != null) {
            float duralility_width = getPrefWidth() / 2;
            float durability_height = 5.0f;
            m_durability = AddCellProgressBar(m_header_title, 
              duralility_width, durability_height, Color.GREEN, Color.RED);
            m_durability.align(Align.left).expandX().fillX();
            m_durability.getActor().Update(m_item.durability);
        }

        // Window size
        float icon_size = GetIconSize();
        SetSize(true, icon_size * 4, 0.0f, 0.0f, icon_size * 4);
        return this;
    }
}
 