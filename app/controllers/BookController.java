package controllers;

import com.google.inject.Inject;
import models.requests.CreateRequest;
import models.requests.UpdateRequest;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.BookService;
import utils.Utils;
import responses.Response;

public class BookController extends Controller
{
	private final BookService bookService;

	@Inject
	public BookController(BookService bookService)
	{
		this.bookService = bookService;
	}

	public Result create(Http.Request request) {
		CreateRequest createRequest = Utils.convertObject(request.body().asJson(), CreateRequest.class);

		return ok(Json.toJson(this.bookService.create(createRequest)));
	}

	public Result list() {
		return ok(Json.toJson(this.bookService.list()));
	}

	public Result get(Long id) {
		return ok(Json.toJson(new Response(this.bookService.get(id))));
	}

	public Result update(Long id, Http.Request request) {
		UpdateRequest updateRequest = Utils.convertObject(request.body().asJson(), UpdateRequest.class);
		return ok(Json.toJson(this.bookService.update(id, updateRequest)));
	}

	public Result delete(Long id) {
		this.bookService.delete(id);
		return ok("Success");
	}
}