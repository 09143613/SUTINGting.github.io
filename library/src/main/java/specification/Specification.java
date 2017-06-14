package specification;

public interface Specification<T> {
	public boolean IsSatisfiedBy(T entity);
}
