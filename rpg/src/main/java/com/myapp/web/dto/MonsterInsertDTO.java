package com.myapp.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonsterInsertDTO {
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
