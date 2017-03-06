package com.shubham.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Flappybird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture bg;
	Texture birds[];
	Texture toptube;
	Texture bottomtube;
	Texture gameover;

	int flapState = 0;
	int gameState = 0;

	float birdY ;
	float velocity = 0;
	float gravity = 2;

	float gap = 500;
	float maxtubeOffset;
	int noOfTubes = 4;
	float tubeOffset[] = new float[noOfTubes] ;
	Random rg;
	float tubeX[] = new float[noOfTubes];
	float disBwTubes;

	Circle birdCircle;
	//ShapeRenderer sr;
	Rectangle topTubesRect[];
	Rectangle bottomTubesRect[];

    //scoring variables
	int score=-1;
	int scoringTube = 0;
	BitmapFont bf;

	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.png");
		gameover = new Texture("gomain.png");

		toptube = new Texture("toptube.png");
		bottomtube = new Texture("bottomtube.png");

		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight()/2 - birds[0].getHeight()/2;

		//sr = new ShapeRenderer();
		birdCircle = new Circle();
		topTubesRect = new Rectangle[noOfTubes];
		bottomTubesRect = new Rectangle[noOfTubes];

		maxtubeOffset = Gdx.graphics.getHeight()/2 - gap/2 - 100;
		disBwTubes = Gdx.graphics.getWidth() * 0.75f;
		rg = new Random();
		bf = new BitmapFont();
		bf.setColor(Color.BLACK);
		bf.getData().setScale(7);

		birdY = Gdx.graphics.getHeight()/2 - birds[0].getHeight()/2;
		for(int i = 0;i<4;i++){

			tubeOffset[i] = (rg.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - gap - 200);
			tubeX[i] = (Gdx.graphics.getWidth()/2 - toptube.getWidth()/2) + Gdx.graphics.getWidth()/2 + i * disBwTubes;
			topTubesRect[i] = new Rectangle();
			bottomTubesRect[i] = new Rectangle();
		}



	}
	public  void startGame(){
		birdY = Gdx.graphics.getHeight()/2 - birds[0].getHeight()/2;
		for(int i = 0;i<4;i++){

			tubeOffset[i] = (rg.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - gap - 200);
			tubeX[i] = (Gdx.graphics.getWidth()/2 - toptube.getWidth()/2) + Gdx.graphics.getWidth()+ i * disBwTubes;
			topTubesRect[i] = new Rectangle();
			bottomTubesRect[i] = new Rectangle();
		}
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(bg,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		if(gameState == 1){

			if(Gdx.input.justTouched()){
				velocity = -30;


			}
			for(int i = 0;i<noOfTubes;i++) {
				if(tubeX[i] < - toptube.getWidth()){
					tubeX[i] += noOfTubes * disBwTubes;
					tubeOffset[i] = (rg.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - gap - 200);
				}else {
					tubeX[i] -= 5;
					if(tubeX[scoringTube] < Gdx.graphics.getWidth()){

						if(scoringTube < noOfTubes - 1){
							scoringTube++;
						}
						else {
							scoringTube = 0;
						}
						score++;
					}
				}
				batch.draw(toptube, tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i]);
				batch.draw(bottomtube, tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomtube.getHeight() + tubeOffset[i]);
				topTubesRect[i] = new Rectangle(tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i],toptube.getWidth(),toptube.getHeight());
				bottomTubesRect[i] = new Rectangle(tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomtube.getHeight() + tubeOffset[i],toptube.getWidth(),toptube.getHeight());
			}

			if(birdY > 0) {
				velocity = velocity + gravity;
				birdY -= velocity;
			}
			else{
				gameState = 2;
			}
		}
		else if(gameState == 0){
			if(Gdx.input.justTouched()){
				gameState = 1;
			}
		}
		else if(gameState == 2){
			batch.draw(gameover,Gdx.graphics.getWidth()/2- gameover.getWidth()/2, Gdx.graphics.getHeight()/2- gameover.getHeight()/2);
			if(Gdx.input.justTouched()){
				gameState = 1;
				startGame();
				velocity = 0;
				score = -1;
				scoringTube = 0;
			}

		}

		if(flapState == 0){
			flapState = 1;
		} else{
			flapState = 0;
		}

		if(score == -1) {
			bf.draw(batch, "0", 100, 200);

		}
		else{
			bf.draw(batch, String.valueOf(score), 100, 200);
		}
		batch.draw(birds[flapState],Gdx.graphics.getWidth()/2 - birds[flapState].getWidth()/2,birdY);
		batch.end();

		//Shaping par for detecting collisions
		//sr.begin(ShapeRenderer.ShapeType.Filled);
		//sr.setColor(Color.RED);
		birdCircle.set(Gdx.graphics.getWidth()/2,birdY + birds[flapState].getHeight()/2, birds[flapState].getWidth()/2 );
		//sr.circle(birdCircle.x,birdCircle.y,birdCircle.radius);
		for(int i = 0;i<noOfTubes;i++){
			//sr.rect(tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i],toptube.getWidth(),toptube.getHeight());
			//sr.rect(tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomtube.getHeight() + tubeOffset[i],toptube.getWidth(),toptube.getHeight());

			if(Intersector.overlaps(birdCircle,topTubesRect[i]) || Intersector.overlaps(birdCircle,bottomTubesRect[i])){
				//Gdx.app.log("Collision","Yes!");
				gameState = 2;
			}
		}
		//sr.end();

	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
