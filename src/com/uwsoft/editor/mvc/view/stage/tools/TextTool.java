/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package com.uwsoft.editor.mvc.view.stage.tools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;
import com.uwsoft.editor.gdx.sandbox.Sandbox;

/**
 * Created by azakhary on 4/30/2015.
 */
public class TextTool implements Tool {

    public static final String NAME = "TEXT_TOOL";

    private String fontFamily;
    private boolean isBold;
    private boolean isItalic;
    private int fontSize;
    private int letterSpacing;
    private Color color;
    private boolean kerningEnabled;
    private int align;

    public TextTool() {
        fontFamily = "arial";
        fontSize = 12;
        color = Color.WHITE;
        kerningEnabled = true;
        align = Align.left;
    }

    @Override
    public void stageMouseDown(float x, float y) {

    }

    @Override
    public void stageMouseUp(float x, float y) {
        Sandbox.getInstance().getItemFactory().createLabel(this, x, y);

        return;
    }

    @Override
    public void stageMouseDragged(float x, float y) {

    }

    @Override
    public void itemMouseDown(float x, float y) {

    }

    @Override
    public void itemMouseUp(float x, float y) {

    }

    @Override
    public void itemMouseDragged(float x, float y) {

    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean isBold) {
        this.isBold = isBold;
    }

    public boolean isItalic() {
        return isItalic;
    }

    public void setItalic(boolean isItalic) {
        this.isItalic = isItalic;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getLetterSpacing() {
        return letterSpacing;
    }

    public void setLetterSpacing(int letterSpacing) {
        this.letterSpacing = letterSpacing;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKerningEnabled() {
        return kerningEnabled;
    }

    public void setKerningEnabled(boolean kerningEnabled) {
        this.kerningEnabled = kerningEnabled;
    }
}
