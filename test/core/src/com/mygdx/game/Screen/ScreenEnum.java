package com.mygdx.game.Screen;

public enum ScreenEnum {
    STARTING_SCREEN{
        public AbstractScreen getScreen(Object...params){
            return new StartingScreen();
        }
    },
    MAIN_GAME{
        public AbstractScreen getScreen(Object...params){
            return new MainGameScreen();
        }
    };
    public abstract AbstractScreen getScreen(Object...params);
}
