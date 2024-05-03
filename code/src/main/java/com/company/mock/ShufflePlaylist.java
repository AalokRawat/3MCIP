package com.company.mock;

import java.util.Random;

public class ShufflePlaylist {
    char[] artists = {'A', 'B', 'C', 'D', 'E'};
    int[][] songs = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5}};

    int aLen = 5;
    int[] len = {5, 5, 5, 5, 5};
    static int totalSongs = 25;
    int preArtistIndex=-1;
    Random random = new Random();
    public static void main(String[] args) {

        for(int i=0;i<totalSongs; i++)
            System.out.println(new ShufflePlaylist().getRandomSong());
        ;
    }

    String getRandomSong() {
        int r = random.nextInt(aLen);

        if(preArtistIndex==r && random.nextInt(2)==1) {
            r = random.nextInt(aLen);
        }
        preArtistIndex = r;

        int l = len[r];
        if(l==0) {
            swap(artists, r, aLen);
            aLen--;
        }
        int r1 = random.nextInt(l);

        String song = new StringBuffer().append(artists[r]).append(songs[r][r1]).toString();
        swap(songs[r], r1, l-1);
        len[r]--;
        aLen--;
        return song;
    }

    void swap(char[] songs, int i, int j) {
        char temp = songs[i];
        songs[i] = songs[j];
        songs[j] = temp;
    }

    void swap(int[] songs, int i, int j) {
        int temp = songs[i];
        songs[i] = songs[j];
        songs[j] = temp;
    }

}
