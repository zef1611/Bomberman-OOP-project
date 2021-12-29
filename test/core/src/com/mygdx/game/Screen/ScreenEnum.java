package com.mygdx.game.Screen;

public enum ScreenEnum {
    STARTING_SCREEN{
        public AbstractScreen getScreen(Object...params){
            return new StartingScreen();
        }
    },
    CHAR_SELECT_SCREEN{
        public AbstractScreen getScreen(Object...params){
            return new CharSelectScreen();
        }
    },
    MAIN_GAME{
        public AbstractScreen getScreen(Object...params){
            return new MainGameScreen();
        }
    };
    public abstract AbstractScreen getScreen(Object...params);
}
