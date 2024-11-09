package school.listecourses.exercicelistedecourses.controller.listeCourses;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions.DuplicateListeCoursesException;
import school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions.InvalidPageSizeException;
import school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions.ListeCoursesNotFoundException;
import school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions.NegativePageNumberException;
import school.listecourses.exercicelistedecourses.domain.ListeCourses;
import school.listecourses.exercicelistedecourses.infrastructure.IListeCoursesRepository;

import java.time.Instant;
import java.util.Date;

@RestController
@RequestMapping("/lists")
public class ListeCoursesController {
//    private final IListeCoursesRepository repository;
//
//    public ListeCoursesController(IListeCoursesRepository repository) {
//        this.repository = repository;
//    }
//
//    @PostMapping
//    @ApiResponses({
//            @ApiResponse(responseCode = "201"),
//            @ApiResponse(responseCode = "409")
//    })
//    public ResponseEntity<ListeCourses> create(@RequestBody ListeCourses list) {
//        if (repository.existsByName(list.getName()))
//            throw new DuplicateListeCoursesException(list.getName());
//        list.setCreatedAt(Date.from(Instant.now()));
//        ListeCourses savedCoursedList = repository.save(list);
//        return new ResponseEntity<>(savedCoursedList, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    @ApiResponses({
//            @ApiResponse(responseCode = "200"),
//            @ApiResponse(responseCode = "400")
//    })
//    public ResponseEntity<Page<ListeCourses>> getAll(@RequestParam(defaultValue = "0") int page,
//                                                     @RequestParam(defaultValue = "10") int size) {
//        if (page < 0)
//            throw new NegativePageNumberException();
//        if (!(size == 10 || size == 20))
//            throw new InvalidPageSizeException();
//        Page<ListeCourses> courseLists = repository.findAll(PageRequest.of(page, size));
//        return new ResponseEntity<>(courseLists, HttpStatus.OK);
//    }
//
//    @GetMapping("{id}")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200"),
//            @ApiResponse(responseCode = "404")
//    })
//    public ListeCourses getById(@PathVariable long id) {
//        return repository
//                .findById(id)
//                .orElseThrow(() -> new ListeCoursesNotFoundException(id));
//    }
//
//    @GetMapping("search/by-name/{name}")
//    @ApiResponse(responseCode = "200")
//    public ResponseEntity<Iterable<ListeCourses>> findByName(@PathVariable() String name) {
//        return new ResponseEntity<>(repository.findByNameContaining(name), HttpStatus.OK);
//    }
//
//    @PutMapping
//    @ApiResponses({
//            @ApiResponse(responseCode = "204"),
//            @ApiResponse(responseCode = "404"),
//            @ApiResponse(responseCode = "409")
//    })
//    public ResponseEntity<Void> update(@RequestBody ListeCourses list) {
//        repository
//                .findById(list.getId())
//                .map(entity -> {
//                    if (repository.existsByNameAndIdIsNot(list.getName(), list.getId()))
//                        throw new DuplicateListeCoursesException(list.getName());
//                    entity.setName(list.getName());
//                    entity.setDescription(list.getDescription());
//                    return repository.save(entity);
//                })
//                .orElseThrow(() -> new ListeCoursesNotFoundException(list.getId()));
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping("{id}")
//    @ApiResponses({
//            @ApiResponse(responseCode = "204"),
//            @ApiResponse(responseCode = "404")
//    })
//    public ResponseEntity<Void> delete(@PathVariable long id) {
//        if (!repository.existsById(id))
//            throw new ListeCoursesNotFoundException(id);
//        repository.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
