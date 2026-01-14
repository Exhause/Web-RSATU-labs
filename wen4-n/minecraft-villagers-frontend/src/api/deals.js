import { api } from "./api";

export function getAllDeals() {
  return api.get("/deals");
}
