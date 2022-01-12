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


@Singleton
class PokemonController @Inject()(ws: WSClient, val controllerComponents: ControllerComponents) extends BaseController{
  
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  val request: WSRequest = ws.url("https://pokeapi.co/api/v2/pokemon/charizard")  
  val futureResponse: Future[WSResponse] = request.get()
  Await.result(futureResponse, 10.second)
  futureResponse.map {
    response => println(response.json)
  }
    


  def getAll(): Action[AnyContent] = Action{
    NoContent
  }



  /*
  val futureResult: Future[String] = ws.url("https://pokeapi.co/api/v2/pokemon/charizard").get().map { response =>
    (response.json \ "name" \ "types").as[String]
  } 
  println(futureResult)
  
  implicit val pokemonJson = Json.format[PokemonTypeData]
  
    
  def getAll(): Action[AnyContent] = Action.async{
    futureResult.map(resp => Ok(Json.toJson(resp)))
    
    if (request == null) {
      NoContent
    }
    else {
      //Ok(futureResult)
      println("nothing here for now")
    
  }*/
}
