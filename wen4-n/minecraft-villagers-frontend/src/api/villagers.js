import { api } from "./api";

export function getVillagerById(id) {
  return api.get(`/villagers/${id}`);
}
