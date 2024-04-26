package com.dmovel.pc02;

class LastPlay {
    private String team;
    private int points;

    public LastPlay() {}

    public String getTeam() {
        return team;
    }

    private void setTeam(String team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    private void setPoints(int points) {
        this.points = points;
    }

    public void setLastPlay(String team, int points) {
        this.team = team;
        this.points = points;
    }
}
