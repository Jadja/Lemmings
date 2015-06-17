package com.mcjadja.lemmings;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.IGameInterface;
import org.andengine.ui.activity.BaseGameActivity;

/**
 * Created by Jadja on 5/31/2015.
 */
public class Level extends BaseGameActivity {

    //Constants:

    private static final int CAMERA_WIDTH = 800;
    private static final int CAMERA_HEIGHT = 480;

    //Fields:

    private Camera myCamera;

    @Override
    public EngineOptions onCreateEngineOptions() {
        this.myCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return null;
    }

    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {

    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {

    }

    @Override
    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {

    }
}
