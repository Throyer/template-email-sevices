import { PageResponse } from '@http/dtos/page-response'

export class Page<T> {
  content: T[]
  page: number
  size: number
  totalPages: number
  totalElements: number

  constructor(
    content: T[],
    page: number,
    size: number,
    totalPages: number,
    totalElements: number,
  ) {
    this.content = content
    this.page = page
    this.size = size
    this.totalPages = totalPages
    this.totalElements = totalElements
  }

  public map<E>(callback: (value: T, index: number, array: T[]) => E): Page<E> {
    return new Page(
      this.content.map(callback),
      this.page,
      this.size,
      this.totalPages,
      this.totalElements,
    )
  }

  public static of<T, E>(
    { content, page, size, totalElements, totalPages }: PageResponse<T>,
    callback: (value: T, index: number, array: T[]) => E,
  ): Page<E> {
    return new Page(
      content.map(callback),
      page,
      size,
      totalPages,
      totalElements,
    )
  }
}
