import { api } from "./api";

export function getAllItems() {
  return api.get("/items");
}

export function createItem(item) {
  return api.post("/items", item);
}

export function deleteItemById(id) {
  api.delete(`/items/${id}`);
}
