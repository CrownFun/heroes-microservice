package com.filewicz.castle.controller;

import com.filewicz.castle.model.Castle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Castle Controller")
public interface CastleController {

    ResponseEntity<Castle> getCastleByName(@ApiParam(value = "Castle name") String castleName);

    ResponseEntity<List<Castle>> getAllCastles();

}
