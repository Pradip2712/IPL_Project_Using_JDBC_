package com.pdp.entity;

public class Player {
	
	private int jrno;
	private String name;
	private int run;
	private int wicket;
	private String tname;
	public Player() {
		super();
	}
	public Player(int jrno, String name, int run, int wicket, String tname) {
		super();
		this.jrno = jrno;
		this.name = name;
		this.run = run;
		this.wicket = wicket;
		this.tname = tname;
	}
	public int getJrno() {
		return jrno;
	}
	public void setJrno(int jrno) {
		this.jrno = jrno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public int getWicket() {
		return wicket;
	}
	public void setWicket(int wicket) {
		this.wicket = wicket;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return " jrno=" + jrno + "  | name=" + name + "  | run=" + run + "  | wicket=" + wicket + "  | tname=" + tname;
	}
	
	
	

}
