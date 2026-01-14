import { api } from "./api";

export function getAllVillages() {
  return api.get("/villages");
}

export function getVillageById(id) {
  return api.get(`/villages/${id}`);
}
