package com.myapp.web.domain;

import lombok.Data;

@Data
public class Monster {
	private int mon_uid;
	private int level;
	private String name;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int health;
	private int mana;
	private String type;
	private int exp;
	private String info;
}
