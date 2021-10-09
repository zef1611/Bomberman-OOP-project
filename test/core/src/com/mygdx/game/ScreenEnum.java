package com.mygdx.game;

import com.badlogic.gdx.Game;

public enum ScreenEnum {
    STARTING_SCREEN{
        public AbstractScreen getScreen(Object...params){
            return new StartingScreen();
        }
    };
//    MAIN_GAME{
//        public AbstractScreen getScreen(Object...params){
//            return new MainGameScreen();
//        }
//    };
    public abstract AbstractScreen getScreen(Object...params);
}
