angular.module('appModule')
.factory('ballplayerService', function($http) {
  var service = {};
  
  var BASE_URL = 'http://localhost:8080/LabRest/api/';

  service.index = function() {
    return $http({
      method : 'GET',
      url : BASE_URL + 'ballplayers'           
    })
  };

  service.show = function(id) {
    return $http({
      method : 'GET',            //http://localhost:8080/LabRest/api/ballplayers/3 should retrieve Matt Kemp for me
      url : BASE_URL + 'ballplayers/{id}'        //OR another way is with ticks `${BASE_URL}ballplayers/${id}`
    })
  };
  
  service.update = function(id, player) {
    return $http({
	  method : 'PUT',
	  url : `${BASE_URL}ballplayers/${id}`,
	  headers : {
	        'Content-Type' : 'application/json'
	      },
	  data : player
	    })
	  };

  service.create = function(player) {
	    return $http({
	      method : 'POST',
	      url : BASE_URL + 'ballplayers',
	      headers : {
	        'Content-Type' : 'application/json'
	      },
	      data : pet
	    })
	  };
  
  service.destroy = function(id) {
		 return $http({  
			method: 'DELETE',
		    url: `${BASE_URL}ballplayers/${id}`
		 })
	  };

	
	//service.destroy = function(id)  {
		//ballplayers.forEach(function(to, idx, array)  {          //IMPLEMENT HERE to delete TODO by id in arrays of todos
   			//if (to.id ===id)  {
	        //  array.splice(idx, 1);
   			//}		
		//});
	//}
	
	return service;
	
	
})    //ensure I close these braces properly Andrew-style