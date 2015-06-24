package com.mcjadja.lemmings;

import android.content.DialogInterface;
import android.view.Display;
import android.view.View;

import org.andengine.engine.FixedStepEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.IGameInterface;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.debug.Debug;

import java.io.IOException;

/**
 * Created by Jadja on 5/31/2015.
 */
public class Level extends SimpleBaseGameActivity implements ButtonSprite.OnClickListener {

    //Constants:

    public static boolean gamesounds = true;
    public static boolean music = true;
    public static boolean vibration = false;

    private static final int CAMERA_WIDTH = 800;
    private static final int CAMERA_HEIGHT = 520;

    private static final int LEMMING_WIDTH = 10;
    private static final int LEMMING_HEIGHT = 25;

    //Fields:

    private BuildableBitmapTextureAtlas mBitmapTextureAtlas;
    private ITextureRegion mLemmingTextureRegion;
    private ITextureRegion mRockTextureRegion;
    private ITextureRegion mStartportalTextureRegion;
    private ITextureRegion mEndportalTextureRegion;
    private BitmapTextureAtlas mBackgroundTexture;
    private TextureRegion mBgTexture;
    private Rectangle mLemming;

    private Camera mCamera;



    @Override
    public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {

    }

    @Override
    protected void onCreateResources() {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

//        this.mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 512, 512);
//        this.mLemmingTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "lemming.jpg");
//        this.mRockTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "Rock.jpg");
//        this.mStartportalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "startPortal.jpg");
//        this.mEndportalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "endPortal.jpg");
//
//        try {
//            this.mBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
//            this.mBitmapTextureAtlas.load();
//        }   catch (ITextureAtlasBuilder.TextureAtlasBuilderException e)  {
//            Debug.e(e);
//        }
    }

    @Override
    protected Scene onCreateScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());

        final VertexBufferObjectManager vertexBufferObjectManager = this.getVertexBufferObjectManager();

        final Scene scene = new Scene();
        scene.setBackground(new Background(1.000f, 0.000f, 0.000f));
        scene.setTouchAreaBindingOnActionDownEnabled(true);

        this.mLemming = new Rectangle(0, 0, LEMMING_WIDTH, LEMMING_HEIGHT, vertexBufferObjectManager);

        scene.attachChild(this.mLemming);

        scene.attachChild(new Line(-400, 260, 400, 260, vertexBufferObjectManager));

        scene.registerUpdateHandler(new IUpdateHandler() {
            @Override
            public void onUpdate(final float pSecondsElapsed) {
            }
            @Override
            public void reset() {
            }
        });

        return scene;
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        this.mCamera.setCenter(0,0);

        return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera);
    }

    //    @Override
//    public EngineOptions onCreateEngineOptions() {
//        this.myCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
//
//
//        return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.myCamera);
//    }
//
//    @Override
//    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
//    }
//
//    @Override
//    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
//        this.mEngine.registerUpdateHandler(new FPSLogger());
//
//
//        final Scene scene = new Scene();
//        scene.setBackground(new Background(1.000f, 0.843f, 0.000f));
//        scene.setBackgroundEnabled(true);
//    }
//
//    @Override
//    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
//
//    }

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
