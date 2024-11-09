package school.listecourses.exercicelistedecourses.application.utils;

public interface IQueryHandler<I, O> {
    O handle(I input);
}
