import { api } from "./api";

export async function getAllItems() {
  return await api.get("/items");
}

export async function getItemById(id) {
  return await api.get(`/items/${id}`);
}

export async function createItem(item) {
  return await api.post("/items", item);
}

export async function updateItem(item) {
  return await api.put("/items", item);
}

export async function deleteItemById(id) {
  await api.delete(`/items/${id}`);
}
