package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Observer.BorderObserve;
//Player state includes still, walking,
//Player direction include left right up down
//Combine to get the current sprite state

public class Player extends Image implements BorderObserve {

    public enum StateEnum{
        WALK("walk"), STILL("still"), HWALK("hwalk"), HSTILL("hstill");
        String stateName;
        StateEnum(String stateName){
            this.stateName = stateName;
        }
        @Override
        public String toString(){
            return stateName;
        }
    }
    public enum DirectionEnum{
        LEFT("left"), RIGHT("right"), UP("up"), DOWN("down"), NONE("none");
        String directionName;
        DirectionEnum(String directionName){
            this.directionName = directionName;
        }
        @Override
        public String toString(){
            return directionName;
        }
    }

    private PlayerInput playerInput;
    private TextureAtlas atlas;
    private Sprite player;
    private Animation <TextureAtlas.AtlasRegion> currentAni;
    private float elapsedTime = 0;
    private MoveByAction currentAction = new MoveByAction();
    private Stage stage;
    private GameStage gameStage;
    private int stepCount=0; // For deciding the animation in update method
    private float borderX, borderY, borderWidth, borderHeight;
    private DirectionEnum direction = DirectionEnum.NONE;
    private StateEnum state = StateEnum.STILL;

    public Player(ColorEnum color, Stage stage, GameStage gameStage) {
//        The player needs to be able to modify the stage add bombs, break blocks...
        this.stage = stage;
        System.out.println(this.stage);
//        For getting the borders
        this.gameStage = gameStage;
//        Import the texture
        atlas = switchCharacter(color);

//        Set the player avatar and bounds
        Array<TextureAtlas.AtlasRegion> stillFrames = atlas.findRegions("bomberman_still");
        currentAni = new Animation<>(1f/15f,stillFrames.get(0));
        player = new Sprite(new TextureAtlas.AtlasSprite(stillFrames.get(0)));
        setBounds(player.getRegionX(), player.getRegionY(), player.getRegionWidth(), player.getRegionHeight());
        setTouchable(Touchable.enabled);

//        For Character to move
        playerInput = new PlayerInput(this);
        input();
//        Work around for character to move 1 step at a time
        currentAction.setDuration(0f);
        Player.this.addAction(currentAction);
//        Receive border
        gameStage.attachObserver(this);
        gameStage.borderNotify();

//        System.out.println(borderX);
//        System.out.println(borderY);
//        System.out.println(borderWidth);
//        System.out.println(borderHeight);

    }

//    This is to render animations
    @Override
    public void draw(Batch batch, float parentAlpha) {
        boolean flip = (direction == DirectionEnum.LEFT);
        elapsedTime += Gdx.graphics.getDeltaTime();
        if(flip){
            batch.draw(currentAni.getKeyFrame(elapsedTime), getX()+getWidth(), getY(),-getWidth(),getHeight());
        }
        else{
            batch.draw(currentAni.getKeyFrame(elapsedTime), getX(), getY(),getWidth(),getHeight());
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    protected void positionChanged(){
        player.setPosition(getX(),getY());
        super.positionChanged();
    }

    public void position(int x, int y) {
        setPosition(x, y);
        player.setPosition(x, y);
    }

    @Override
    public void update(){
        this.borderX = gameStage.getBorderX();
        this.borderY = gameStage.getBorderY();
        this.borderWidth = gameStage.getBorderWidth();
        this.borderHeight = gameStage.getBorderHeight();
        System.out.println(borderX);
        System.out.println(borderY);
        System.out.println(borderWidth);
        System.out.println(borderHeight);
    }

//    Every input happens here + Update the animation
    public void input(){
        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode){
//                playerInput will deal with movement logic
                playerInput.inputContent(keycode);
                return true;
            }
        });
    }

    protected TextureAtlas switchCharacter(ColorEnum color) {
        String colorName = color.toString();
        String fileName = "sprite_sheet/character/bomberman_" + colorName + "/bomber_" + colorName + ".txt";
        return new TextureAtlas(Gdx.files.internal(fileName));
    }
//---------------------------GETTER/SETTERS------------------------
    public StateEnum getState(){
        return state;
    }
    protected  void setState(StateEnum state){
        this.state = state;
    }

    public DirectionEnum getDirection(){
        return direction;
    }
    protected  void setDirection(DirectionEnum direction){
        this.direction = direction;
    }

    public int getStepCount(){
        return stepCount;
    }
    protected void setStepCount(int stepCount){
        this.stepCount = stepCount;
    }

    public Animation <TextureAtlas.AtlasRegion> getCurrentAni(){
        return currentAni;
    }
    protected void setCurrentAni(Animation <TextureAtlas.AtlasRegion> currentAni){
        this.currentAni = currentAni;
    }

    public float getElapsedTime(){
        return elapsedTime;
    }
    protected void setElapsedTime(float elapsedTime){
        this.elapsedTime = elapsedTime;
    }

    public MoveByAction getCurrentAction(){ return currentAction;}
    public void setCurrentAction(MoveByAction currentAction){this.currentAction = currentAction;}

    public TextureAtlas getAtlas(){ return atlas;}

    public Stage getStage(){ return stage;}

    public float getBorderX(){return borderX;}
    public float getBorderY(){ return borderY;}
    public float getBorderWidth(){return borderWidth;}
    public float getBorderHeight(){return borderHeight;}


}
