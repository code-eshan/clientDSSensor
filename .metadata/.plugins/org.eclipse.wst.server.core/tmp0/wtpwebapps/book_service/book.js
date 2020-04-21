/**
 * 
 */

function getDetails(){
	jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/" + $("#id").val(),
        type: "GET",
        contentType: "application/json",  
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
            //here is your json.
              // process it
        	  $("#title").text(data.title);
        	  $("#price").text(data.price);

        },
        error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Sorry! Book not found!");
        		$("#price").text("");
        },
        timeout: 120000,
    });
};

//POSTDETAILS USING AJAX
function postDetails() {
	
	//Getting the bookDetails
	const bookData = {
			"id": $("#getId").val(),
			"price": $("#getPrice").val(),
			"title": $("#getTitle").val()
		};
	
	
	$.ajax({
		url: "http://localhost:8080/book_service/rest/books/",
		type: "POST",
		data: JSON.stringify(bookData),			
		contentType: "application/json",
		dataType: "json",
        success: function(data, textStatus, errorThrown) {
        	  $("#response").text("Book Added Successfully");

        },
        error : function(jqXHR, textStatus, errorThrown) {
        		alert(errorThrown).text("Error");
        },
        timeout: 120000,
		
	});
};

//Delete a particular book
function deleteBook() {
	
	$.ajax({
		url: "http://localhost:8080/book_service/rest/books/" + $("#deleteId").val(),
		type: "DELETE",
		contentType: "application/json",
		dataType: "json",
		success: function(data, textStatus, errorThrown) {
			$("#deleteResponse").text("Book Deleted Successfully");
		},
		
		error: function(jqXHR, textStatus, errorThrown) {
			alert("The particular book id not found");
		}
	});
}