package models

import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Reads}


case class PokemonType(slot1: List[String], slot2: List[String] )

/*
object PokemonType {
	implicit val pokemonType: Reads[PokemonType] = (
		(JsPath \ "type" ).read[String])(PokemonType.apply _)
}
*/

/*
[
	{
		"slot":1,
		"type": {
			"name":"fire",
			"url":"https://pokeapi.co/api/v2/type/10/"
		}
	},
	{
		"slot":2,
		"type": { 
			"name":"flying",
			"url":"https://pokeapi.co/api/v2/type/3/"
		}
	}
]
*/
