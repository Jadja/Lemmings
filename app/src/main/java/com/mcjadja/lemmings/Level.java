package com.mcjadja.lemmings;

import android.view.Display;

import org.andengine.engine.FixedStepEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.IGameInterface;
import org.andengine.ui.activity.BaseGameActivity;

/**
 * Created by Jadja on 5/31/2015.
 */
public class Level extends BaseGameActivity {

    //Constants:

    public static boolean gamesounds = true;
    public static boolean music = true;
    public static boolean vibration = false;

    private static final int CAMERA_WIDTH = 800;
    private static final int CAMERA_HEIGHT = 520;

    //Fields:

    private Camera myCamera;

    @Override
    public EngineOptions onCreateEngineOptions() {
        this.myCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);


        return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.myCamera);
    }

    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
        this.mEngine.registerUpdateHandler(new FPSLogger());


        final Scene scene = new Scene();
        scene.setBackground(new Background(1.000f, 0.843f, 0.000f));
        scene.setBackgroundEnabled(true);
    }

    @Override
    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {

    }

    public static void ToggleMusic(boolean musictoggle)  {
        music = musictoggle;
    }

    public static void ToggleSound(boolean soundtoggle)  {
        gamesounds = soundtoggle;
    }

    public static void ToggleVibration(boolean vibrationtoggle)  {
        vibration = vibrationtoggle;
    }

}
