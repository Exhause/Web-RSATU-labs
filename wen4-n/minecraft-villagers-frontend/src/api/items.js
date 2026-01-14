import { api } from "./api";

export function getAllItems() {
  return api.get("/items");
}
