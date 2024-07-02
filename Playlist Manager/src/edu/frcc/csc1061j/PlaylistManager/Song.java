package edu.frcc.csc1061j.PlaylistManager;


public class Song 
{
	private String artistName;
	private String songName;
	
	public Song(String artistName, String songName)
	{
		this.artistName = artistName;
		this.songName = songName;
	}
	
//	@Override
//	public boolean equals(Object otherSong)
//	{
//		if (otherSong instanceof Song)
//		{
//			Song other = (Song) (otherSong);
//			
//			if (songName.equals));
//		}
//	}
	
	public String getArtistName() 
	{
		return artistName;
	}
	public void setArtistName(String artistName) 
	{
		this.artistName = artistName;
	}
	public String getSongName() 
	{
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
}
