package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	private String Text;
	private int Likes;
	private boolean Featured;
	/**
	 * Complete con su implementación
	 */

	public WallPostImpl () {
		this.Text= "Undefined post";
		this.Likes= 0;
		this.Featured= false;
	}
	
	public String getText() {
		return this.Text;
	}
	
	public void setText(String txt) {
		this.Text= txt;
	}
	
	public int getLikes() {
		return this.Likes;
	}
	
	public void like() {
		this.Likes++;
	}
	
	public void dislike() {
		if(this.Likes > 0) {
			this.Likes--;
		}
	}
	
	public boolean isFeatured() {
		return this.Featured;
	}
	
	public void toggleFeatured() {
		if(this.Featured == false) {
			this.Featured= true;
		}
		else
			this.Featured= false;
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

}
