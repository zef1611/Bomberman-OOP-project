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
    STAGE_SELECT_SCREEN{
        public AbstractScreen getScreen(Object...params){
            return new StageSelectScreen();
        }
    },
    MAIN_GAME{
        public AbstractScreen getScreen(Object...params){
            return new MainGameScreen();
        }
    },
    GAME_OVER{
        public AbstractScreen getScreen(Object...params){
            return new GameOverScreen();
        }
    };
    public abstract AbstractScreen getScreen(Object...params);
}
