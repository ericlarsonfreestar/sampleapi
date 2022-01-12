package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import play.api.libs.json._
import javax.inject._
import models.PokemonTypeData

import play.api.mvc._
import play.api.libs.ws.{WSRequest, WSResponse, WSClient}
import play.api.http.HttpEntity
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.io.Source.fromURL

@Singleton
class PokemonController @Inject()(ws: WSClient, val controllerComponents: ControllerComponents) extends BaseController{
  
  @throws(classOf[java.io.IOException])
  def get(url: String): String = fromURL(url).mkString

  val pokemonApi = get("https://pokeapi.co/api/v2/pokemon/charizard")

  //implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  //val request: WSRequest = ws.url("https://pokeapi.co/api/v2/pokemon/charizard")  
  //val futureResponse: Future[WSResponse] = request.get()
  //Await.result(futureResponse, 10.second)



  
  //def getPokemonType: List[String]
  /*
  futureResponse.map {
    response => 
      println((response.json \ "types" \ "name").get)
  }
  */

  // Create a method to call the pokemon API with for the types 
  


  // how to read the Future[Json]
  
  
  
  def getAll(): Action[AnyContent] = Action{
    NoContent
  }
}
