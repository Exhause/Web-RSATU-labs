import { api } from "./api";

export async function getAllVillages() {
  return await api.get("/villages");
}

export async function getVillageById(id) {
  return await api.get(`/villages/${id}`);
}

export async function createVillage(village) {
  return await api.post("/villages", village);
}

export async function updateVillage(village) {
  return await api.put("/villages", village);
}

export async function deleteVillageById(id) {
  await api.delete(`/villages/${id}`);
}
