package es.scandel.christmas.controller;

import es.scandel.christmas.model.Gift;
import es.scandel.christmas.service.GiftService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/gifts")
public class GiftController {


    private static final Logger LOGGER = LoggerFactory.getLogger(GiftController.class);

    @Autowired
    private GiftService giftService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return a list of gifts", notes = "Get a list of gifts")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No data found.")
    })
    public List<Gift> getAllGift(HttpServletResponse response) {

        LOGGER.info("GET -> /gifts");
        List<Gift> giftList = giftService.findAll();
        if (giftList == null) {
            LOGGER.info("No Gifts found");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return giftList;
    }

    @RequestMapping(value = "/{idGift}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return a Gift", notes = "Get a Gift by Id")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "No data found.")
    })
    public Gift getGift(@PathVariable String idGift,
                        HttpServletResponse response) {

        LOGGER.info("GET -> /gifts/{}", idGift);
        Gift gift = giftService.findById(idGift);
        if (gift == null) {
            LOGGER.info("Gift with id {} not found", idGift);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return gift;
    }
//
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Return all Gifts", notes = "Get all Gifts")
//    public List<Gift> getAllGifts(@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) Integer pageNumber) {
//        LOGGER.info(" GET -> /Gifts?pageSize={}&pageNumber={}");
//        return giftService.findAllGift(pageSize, pageNumber);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Create a Gift", notes = "Create a new Gift")
//    @ApiResponses({
//            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Gift created."),
//            @ApiResponse(code = HttpServletResponse.SC_CONFLICT, message = "Gift already exists."),
//            @ApiResponse(code = HttpServletResponse.SC_NOT_ACCEPTABLE, message = "Mandatory fields error")
//    })
//    public Gift saveGift(@RequestBody Gift Gift, HttpServletResponse response) {
//
//
//        LOGGER.info("POST -> /Gifts   [{}]", Gift.getGiftId());
//        Gift createdGift = null;
//        if (Gift.getGiftId() == null) {
//            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
//        } else {
//
//            Gift.setCreationDate(new Date());
//            Gift.setModificationDate(new Date());
//
//            createdGift = giftService.saveGift(Gift);
//
//            if (createdGift != null) {
//                response.setHeader("Location", "/Gifts/" + createdGift.getGiftId());
//                response.setStatus(HttpServletResponse.SC_CREATED);
//            } else
//                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//
//        return createdGift;
//    }
//
//    @RequestMapping(value = "/{idGift}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Delete a Gift", notes = "Delete a Gift by Id")
//    public void deleteUser(@PathVariable String idGift, HttpServletResponse response) {
//        LOGGER.info(" DELETE -> /Gifts/{}", idGift);
//        giftService.deleteGift(idGift);
//    }
//
//    @RequestMapping(value = "/{idGift}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Update a Gift", notes = "Update a Gift by Id")
//    @ApiResponses({
//            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Gift doesn't exists."),
//            @ApiResponse(code = HttpServletResponse.SC_NOT_ACCEPTABLE, message = "Validation fails")
//    })
//    public Gift updateGift(@RequestBody Gift Gift, HttpServletResponse response) {
//
//        LOGGER.info("PUT -> /Gifts/{}", Gift.getGiftId());
//        if (Gift.getGiftId() == null) {
//            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
//        } else {
//
//            Gift.setModificationDate(new Date());
//
//            Gift GiftCreated = giftService.updateGift(Gift);
//
//            if (GiftCreated != null)
//                response.setStatus(HttpServletResponse.SC_OK);
//            else
//                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//
//        return Gift;
//    }
//
//    @RequestMapping(value = "/{idGift}", method = RequestMethod.PATCH, consumes = "application/merge-patch+json")
//    @ApiOperation(value = "Patch a Gift", notes = "Update a Gift using a merge patch")
//    @ApiResponses({
//            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Gift doesn't exists."),
//            @ApiResponse(code = HttpServletResponse.SC_NOT_ACCEPTABLE, message = "Validation fails")
//    })
//    public Gift mergePatchGift(@PathVariable String idGift,
//                                   @RequestBody String json,
//                                   HttpServletResponse response) {
//
//        LOGGER.info("PATH -> /Gifts/{}", idGift);
//
//        Gift existingGift;
//        Gift patchedGift = null;
//        if (idGift == null) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        } else if ((existingGift = giftService.findGift(idGift)) == null) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        } else {
//
//            existingGift.setModificationDate(new Date());
//
//            patchedGift = giftService.mergePatchGift(existingGift, json);
//
//            if (patchedGift != null)
//                response.setStatus(HttpServletResponse.SC_OK);
//            else
//                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//
//        return patchedGift;
//    }
}
