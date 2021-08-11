// import heapq

// def solution(n, start, end, roads, traps):
//     edge = [[] for _ in range(n + 1)]
//     mask_idx = {t : n for n, t in enumerate(traps)}
//     traps = tuple(traps)

//     for road in roads:
//         a, b, d = road
//         edge[a].append((b, d))
//         edge[b].append((a, -d))

//     # bfs
//     heap = [(0, start, 0)]
//     dist = {}
//     while heap:
//         d, idx, mask = heapq.heappop(heap)
//         if dist.get((idx, mask), None):
//             continue

//         dist[(idx, mask)] = d
//         if idx == end:
//             answer = d
//             print('break')
//             break;

//         direction = 1
//         if idx in traps and (mask & (1 << mask_idx[idx])):
//             direction *= -1

//         for near_idx, near_d in edge[idx]:
//             if near_idx in traps and (mask & (1 << mask_idx[near_idx])):
//                 near_d *= -1

//             if near_d * direction > 0:
//                 new_mask = mask
//                 if near_idx in traps:
//                     if mask & (1 << mask_idx[near_idx]):
//                         new_mask = mask & ~(1 << mask_idx[near_idx])
//                     else:
//                         new_mask = mask | (1 << mask_idx[near_idx])

//                 heapq.heappush(heap, (d + near_d * direction, near_idx, new_mask))

//     return answer
