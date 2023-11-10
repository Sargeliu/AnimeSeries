package com.example.animeseries;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AnimeResponse implements Serializable {
	@SerializedName("docs")
	private List<Anime> anime;

	public AnimeResponse(List<Anime> anime) {
		this.anime = anime;
	}

	public List<Anime> getAnime() {
		return anime;
	}

	@Override
	public String toString() {
		return "AnimeResponse{" +
				"anime=" + anime +
				'}';
	}
}