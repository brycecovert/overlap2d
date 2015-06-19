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

package com.uwsoft.editor.mvc.view.ui.properties.panels;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.util.Validators;
import com.kotcrab.vis.ui.widget.NumberSelector;
import com.kotcrab.vis.ui.widget.VisCheckBox;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisSelectBox;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisValidableTextField;
import com.uwsoft.editor.mvc.event.CheckBoxChangeListener;
import com.uwsoft.editor.mvc.event.KeyboardListener;
import com.uwsoft.editor.mvc.event.SelectBoxChangeListener;
import com.uwsoft.editor.mvc.view.ui.properties.UIItemCollapsibleProperties;
import com.uwsoft.editor.renderer.legacy.data.LightVO;

/**
 * Created by azakhary on 4/28/2015.
 */
public class UILightItemProperties extends UIItemCollapsibleProperties {

    private VisCheckBox isStaticCheckBox;
    private VisCheckBox isXRayCheckBox;
    private NumberSelector rayCountSelector;

    private VisValidableTextField pointLightRadiusField;
    private VisValidableTextField coneInnerAngleField;
    private VisValidableTextField coneDistanceField;

    private VisLabel lightTypeLabel;

    private VisTable secondaryTable;

    public UILightItemProperties() {
        super("Light");
        Validators.FloatValidator floatValidator = new Validators.FloatValidator();

        isStaticCheckBox = new VisCheckBox(null);
        isXRayCheckBox = new VisCheckBox(null);
        rayCountSelector = new NumberSelector(null, 4, 4, 5000, 1);
        lightTypeLabel = new VisLabel();
        pointLightRadiusField = new VisValidableTextField(floatValidator);
        coneInnerAngleField = new VisValidableTextField(floatValidator);
        coneDistanceField = new VisValidableTextField(floatValidator);

        secondaryTable = new VisTable();

        mainTable.add(new VisLabel("Type: ", Align.right)).padRight(5).width(75).right();
        mainTable.add(lightTypeLabel).left();
        mainTable.row().padTop(5);
        mainTable.add(new VisLabel("Is Static: ", Align.right)).padRight(5).width(75).right();
        mainTable.add(isStaticCheckBox).left();
        mainTable.row().padTop(5);
        mainTable.add(new VisLabel("Is XRay: ", Align.right)).padRight(5).width(75).right();
        mainTable.add(isXRayCheckBox).left();
        mainTable.row().padTop(5);
        mainTable.add(new VisLabel("Ray Count: ", Align.right)).padRight(5).width(75).right();
        mainTable.add(rayCountSelector).left();
        mainTable.row().padTop(5);
        setListeners();
    }

    public void initPointFields() {
        secondaryTable.clear();

        secondaryTable.add(new VisLabel("Radius: ", Align.right)).padRight(5).width(55).right();
        secondaryTable.add(pointLightRadiusField).width(70).left();
        secondaryTable.row().padTop(5);
    }

    public void initConeFields() {
        secondaryTable.clear();

        secondaryTable.add(createLabel("Distance: ", Align.right)).padRight(5).fillX().right();
        secondaryTable.add(coneDistanceField).width(70).left();
        secondaryTable.row().padTop(5);
        secondaryTable.add(createLabel("Type: ", Align.right)).padRight(5).fillX().right();
        secondaryTable.add(coneInnerAngleField).width(70).left();
        secondaryTable.row().padTop(5);
    }

    public void setType(LightVO.LightType type) {
        if (type == LightVO.LightType.POINT) {
            lightTypeLabel.setText("Point Light");
            initPointFields();
        } else if (type == LightVO.LightType.CONE) {
            lightTypeLabel.setText("Cone Light");
            initConeFields();
        }
    }

    public int getRayCount() {
        return rayCountSelector.getValue();
    }

    public void setRayCount(int count) {
        rayCountSelector.setValue(count);
    }

    public boolean isStatic() {
        return isStaticCheckBox.isChecked();
    }

    public void setStatic(boolean isStatic) {
        isStaticCheckBox.setChecked(isStatic);
    }

    public boolean isXRay() {
        return isXRayCheckBox.isChecked();
    }

    public void setXRay(boolean isXRay) {
        isXRayCheckBox.setChecked(isXRay);
    }

    public String getRadius() {
        return pointLightRadiusField.getText();
    }

    public void setRadius(String radius) {
        pointLightRadiusField.setText(radius);
    }

    public String getAngle() {
        return coneInnerAngleField.getText();
    }

    public void setAngle(String angle) {
        coneInnerAngleField.setText(angle);
    }

    public String getDistance() {
        return coneDistanceField.getText();
    }

    public void setDistance(String distance) {
        coneDistanceField.setText(distance);
    }

    @Override
    public String getPrefix() {
        return this.getClass().getCanonicalName();
    }

    private void setListeners() {
        isStaticCheckBox.addListener(new CheckBoxChangeListener(getUpdateEventName()));
        isXRayCheckBox.addListener(new CheckBoxChangeListener(getUpdateEventName()));
        rayCountSelector.addChangeListener(number -> facade.sendNotification(getUpdateEventName()));
        pointLightRadiusField.addListener(new KeyboardListener(getUpdateEventName()));
        coneInnerAngleField.addListener(new KeyboardListener(getUpdateEventName()));
        coneDistanceField.addListener(new KeyboardListener(getUpdateEventName()));
    }
}
