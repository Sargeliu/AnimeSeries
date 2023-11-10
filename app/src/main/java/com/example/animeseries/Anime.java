package com.example.animeseries;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "favourite_anime")
public class Anime implements Serializable {
	@PrimaryKey
	@SerializedName("id")
	private final int id;
	@SerializedName("name")
	private final String title;
	@SerializedName("year")
	private final int year;
	@SerializedName("description")
	private final String description;
	@SerializedName("shortDescription")
	private final Object shortDescription;
	@SerializedName("isSeries")
	private final boolean isSeries;
	@Embedded
	@SerializedName("poster")
	private final Poster poster;
	@Embedded
	@SerializedName("rating")
	private final Rating rating;

	public Anime(int id, String title, int year, String description, Object shortDescription, boolean isSeries, Poster poster, Rating rating) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.description = description;
		this.shortDescription = shortDescription;
		this.isSeries = isSeries;
		this.poster = poster;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getDescription() {
		return description;
	}

	public Object getShortDescription() {
		return shortDescription;
	}

	public boolean isSeries() {
		return isSeries;
	}

	public Poster getPoster() {
		return poster;
	}

	public Rating getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Anime{" +
				"id=" + id +
				", title='" + title + '\'' +
				", year=" + year +
				", description='" + description + '\'' +
				", shortDescription=" + shortDescription +
				", isSeries=" + isSeries +
				", poster=" + poster +
				", rating=" + rating +
				'}';
	}
}